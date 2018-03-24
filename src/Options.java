package mininet;

import java.util.*;

enum Options {
	LIST_EVERYONE,
	ADD_PERSON,
	SELECT_PERSON,
	UPDATE_PERSON,
	CONNECT_PERSONS,
	IS_DIRECT_FRIEND,
	DELETE_PERSON,
	QUIT;
	
	private static HashMap<Integer, Options> hash = new HashMap<Integer, Options>();
	
	static {
		for(Options option : values()) {
		   hash.put(option.ordinal(), option);
		}
	}
	
	public static boolean ignoreOptions(int n) {
		Options tmp =(Options) hash.get(n);
		
		if(tmp == null) {
			return true;
		}
		
		return false;
		
	};
	
	public static Options getOption(int n) {
		Options type =(Options) hash.get(n);
		return type;
	}
};

