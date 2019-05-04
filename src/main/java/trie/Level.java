package trie;

import java.util.HashSet;
import java.util.Set;

class Level {
	private Set<Character> level;

	Level(Character root) {
		level = new HashSet<>();
		level.add(root);
	}

	void add(Character character) {
		level.add(character);
	}

	boolean contains(Character character) {
		return level.contains(character);
	}
}
