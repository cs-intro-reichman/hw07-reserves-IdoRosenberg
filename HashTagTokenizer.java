

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		while(!in.isEmpty()){
			for(int i=0; i<3000; i++)
				dictionary[i] = in.readLine();
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String[] dictionary) {
		int i=0;
		boolean exists = false;
		while(i < 3000 && !exists){
			if(dictionary[i].equals(word)){
				exists = true;
			}
			else i++;
		}

		return exists;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
		
		hashtag = hashtag.toLowerCase();
        int N = hashtag.length();
		int j = 1;


        for (int i = 0; i < N ; i++) {
			if(existInDictionary(hashtag.substring(0, j), dictionary)){
				System.out.println(hashtag.substring(0, j));
				breakHashTag(hashtag.substring(j), dictionary);
				break;
			}
			else j++;
        }
    }
}
