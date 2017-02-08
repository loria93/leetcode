package person.loria.leetcode;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class LRUCache {
    
	private class CacheLine {
		public int frequency = 0;
		public int key = 0;
		public Integer value = 0;
		
		public CacheLine(Integer _key, int _value, int _frequency) {
			value = _value;
			key = _key;
			frequency = _frequency;
		}
	}
	
	private HashMap<Integer, CacheLine> map;
	private List<CacheLine> list;
	private int capacity;
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        list = new ArrayList<CacheLine>();
        map = new HashMap<Integer, CacheLine>();
    }
    
    public int get(int key) {
    	Integer keyObject = Integer.valueOf(key);
        if(map.containsKey(keyObject)) {
        	CacheLine cl = map.get(keyObject);
        	list.remove(cl);
        	list.add(cl);
        	// Maintain the heap
        	return cl.value;
        } else {
        	return -1;
        }
    }
    
    public void set(int key, int value) {
        Integer keyObject = Integer.valueOf(key);
        if(map.containsKey(keyObject)) { 
        	// cache hit
        	CacheLine cl = map.get(keyObject);
        	cl.value = value;
        	list.remove(cl);
        	list.add(cl);
        } else { 
        	// cache miss
        	CacheLine cl = new CacheLine(keyObject, value, 0);
        	if(list.size() >= capacity) {
        		CacheLine swapOut = list.remove(0);
        		map.remove(swapOut.key);
        	}
        	list.add(cl);
    		map.put(keyObject, cl);
        }
    }
}