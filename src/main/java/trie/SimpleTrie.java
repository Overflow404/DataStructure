package trie;

import java.util.Hashtable;
import java.util.Map;

public class SimpleTrie {

	private Map<Integer, Level> trie;

	public SimpleTrie() {
		trie = new Hashtable<>();
	}

	public void add(String word) {
		if (word == null) {
			throw new NullPointerException("Null string aren't allowed!");
		}

		for (int i = 0; i < word.length(); i++) {
			Character current = word.charAt(i);

			if (levelExist(i)) {
				Level level = trie.get(i);
				level.add(current);
			} else {
				Level level = new Level(current);
				trie.put(i, level);
			}
		}
	}

	public boolean contains(String word) {
		if (word == null) {
			throw new NullPointerException("Null string aren't allowed!");
		}

		for (int i = 0; i < word.length(); i++) {
			Character current = word.charAt(i);

			Level level = trie.get(i);

			if (!level.contains(current)) {
				return false;
			}
		}

		return true;
	}

	public void remove(String word) {
		if (word == null) {
			throw new NullPointerException("Null string aren't allowed!");
		}
		//TODO


	}

	private boolean levelExist(int level) {
		return trie.get(level) != null;
	}
}
