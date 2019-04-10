/*
7.12 Implement Run-length Encoding
"aaaabcccaa" = "4a1b3c2a"
*/
public static String RLE(String s) {
    String out = "";

    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; i++) {
        int count = 1;
        char curr = arr[i];

        int j = i;
        while (j < arr.length && arr[j] == arr[j + 1]) {
            count++;
            j++;
        }

        out += count;
        out += curr;

        i = j;
    }

    return out;
}