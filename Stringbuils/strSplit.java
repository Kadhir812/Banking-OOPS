package Stringbuils;

public class strSplit {
    public static void main(String[] args){
        // String str = "we#will#play#sports";
        // String list[] = str.split("#");

        // for (String s : list) {
        //     System.out.println(s);
        // }

      
        String sentence = "Java is powerful and fun";
        String[] words = sentence.split(" ");
        System.out.println("Word lengths:");
        for (String word : words) {
            System.out.println(word + ": " + word.length());
        }

      
        String sentence2 = "Programming makes life easier";
        String[] words2 = sentence2.split(" ");
        System.out.println("\nVowel counts:");
        for (String word : words2) {
            int vowelCount = 0;
            for (char c : word.toLowerCase().toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowelCount++;
                }
            }
            System.out.println(word + ": " + vowelCount);
        }


        

    }
}
