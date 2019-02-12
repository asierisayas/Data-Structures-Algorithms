/*
13.1 Test for Palindromic Permutation
Write a program to test whether the letters forming a string can
be permuted to form a palindrome
*/
public boolean canPermutePalindrome(String s) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
        if (!set.contains(s.charAt(i)))
            set.add(s.charAt(i));
        else
            set.remove(s.charAt(i));
    }
    
    return set.size() <= 1;
}

/*
13.2 Is an anonymous letter constructible
Write a program which takes text for an anonymous letter 
and text for a magazine and determines if it is possible to 
write the anonymous letter using the magazine
*/
public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> note = new HashMap<>();
    Map<Character, Integer> mag = new HashMap<>();
    
    for (char c : ransomNote.toCharArray()) {
        note.put(c, note.getOrDefault(c, 0) + 1);
    }
    for (char c : magazine.toCharArray()) {
        mag.put(c, mag.getOrDefault(c, 0) + 1);
    }
    
    for (char c : note.keySet()) {
        if (!mag.containsKey(c) || note.get(c) > mag.get(c)) {
            return false;
        }
    }
    
    return true;
}