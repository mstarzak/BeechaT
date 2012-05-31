package com.bakoma.beechat;

import java.util.ArrayList;
import java.util.HashMap;
 
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
 
public class MessageAdapter extends BaseAdapter {
	
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater = null;
    
    public MessageAdapter(Activity activity, ArrayList<HashMap<String, String>> data) {
        this.activity	= activity;
        this.data		= data;
        inflater 		= (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    public int getCount() {
        return data.size();
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        HashMap<String, String> message = new HashMap<String, String>();
        message = data.get(position);
        
        if(message.get(BeechaT.KEY_TYPE).equals("w")) {
            vi = inflater.inflate(R.layout.message, null);
        } else {
        	vi = inflater.inflate(R.layout.my_message, null);
        }
 
        TextView author 	= (TextView)vi.findViewById(R.id.msgauthor); // messsage author
        TextView content 	= (TextView)vi.findViewById(R.id.msgcontent); // message content
        TextView time 		= (TextView)vi.findViewById(R.id.msgtime); // duration
        //ImageView image		=(ImageView)vi.findViewById(R.id.userimage); // thumb image
 
        // Setting all values in listview
        author.setText(message.get(BeechaT.KEY_AUTHOR));
        content.setText(message.get(BeechaT.KEY_CONTENT));
        time.setText(message.get(BeechaT.KEY_TIME));
        //.DisplayImage(song.get(CustomizedListView.KEY_THUMB_URL), thumb_image);
        return vi;
    }
    
	public Activity getActivity() {
		return activity;
	}
}