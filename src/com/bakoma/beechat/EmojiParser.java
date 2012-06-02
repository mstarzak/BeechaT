package com.bakoma.beechat;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiParser {
	/**
	 * Map for emoji
	 */
	private HashMap<String, String> emojiMap;
	
	/**
	 * Constructor of EmojiParser, build map emoji => emoji_filename
	 */
	public EmojiParser() {
		this.emojiMap = new HashMap<String, String>();
		
		this.emojiMap.put("8-)", "emo_im_cool");
		this.emojiMap.put("8)", "emo_im_cool");
		this.emojiMap.put(":'", "emo_im_crying");
		this.emojiMap.put("8", "emo_im_embarrassed");
		this.emojiMap.put("!", "emo_im_foot_in_mouth");
		this.emojiMap.put(")", "emo_im_happy");
		this.emojiMap.put("<3", "emo_im_heart");
		this.emojiMap.put("*", "emo_im_kissing");
		this.emojiMap.put("d", "emo_im_laughing");
		this.emojiMap.put("x", "emo_im_lips_are_sealed");
		this.emojiMap.put("@", "emo_im_mad");
		this.emojiMap.put("$", "emo_im_money_mouth");
		this.emojiMap.put("|", "emo_im_pokerface");
		this.emojiMap.put("(", "emo_im_sad");
		this.emojiMap.put("c", "emo_im_sad");
		this.emojiMap.put("}", "emo_im_smirk");
		this.emojiMap.put("o", "emo_im_surprised");
		this.emojiMap.put("p", "emo_im_tongue_sticking_out");
		this.emojiMap.put("^", "emo_im_undecided");
		this.emojiMap.put(";)", "emo_im_winking");
		this.emojiMap.put(";-)", "emo_im_winking");
		this.emojiMap.put("oO", "emo_im_wtf");
		this.emojiMap.put("#", "emo_im_yelling");
	}
	
	/**
	 * Parse each text emoji to proper image
	 * 
	 * @param input Text to search for emoji
	 * @return String with &lt;img src="emoji"&gt;
	 */
	public String parse(String input) {
		String output = input;
		
		Pattern p = Pattern.compile("[:;8][',]?-?(?:[sSdDpPcCoOxX#@*$|()8!}^])|(\\<3)|(oO)", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(output);
		
		while(m.find()) {
			String match = m.group();
			String path = this.emojiMap.get(match);
			if(path == null) {
				path = this.emojiMap.get(match.substring(match.length()-1).toLowerCase());
			}
			
			if(path != null) {
				output = m.replaceAll("<img src=\"" + path + "\">");
			}
		}

		return output;
	}
}
