class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

// Adrian and Asael's Encryption Project

String originale = "Papoy is Cool";
String reversed = reverse(originale);
String Ciphered = encodeC(reversed);
String Letternumber = letternumber(Ciphered);
String Decryptedletters = decryptLetternumber(Letternumber);
String Decoded = decodeC(Decryptedletters);
String Final = reverse(Decoded);

  void init(){

    print(originale);
    print(reversed);
    print(Ciphered);
    print(Letternumber);
    print(Decryptedletters);
    print(Decoded);
    print(Final);

  }
 
  
  // Encoding #1 and Decoding #3: reversing a string
  String reverse(String txt){
    String build ="";
    for(int x=0; x<= txt.length()-1; x++){
      build = txt.charAt(x) + build;
    }
    return build;
  }
  
  
  // Encoding #2: Ciphering by Random numbers
  String encodeC(String txt){
    String build = "";
    int ascii = 0;
    char ch = '\0';
    
    for(int x=0; x<=txt.length()-1; x++){
      ch = txt.charAt(x);
      ascii = (int)ch;
      ascii += 6;
      build += (char)ascii;
    }     
    return build;
  }

  // Decoding #2: Ciphering by random numbers
  String decodeC(String txt){
    String build="";
    int ascii;
    char ch='\0';
    for(int x=0; x<=txt.length()-1; x++){
      ch=txt.charAt(x);
      ascii = (int)ch;
      ascii -= 6;
        build += (char)ascii;
    }
    return build;
  }

  //  Encoding #3: Letter to number coding
  // Read the "Letter to number encryption explanation" google doc for the explanation of this function
  String letternumber(String s){
    String build = "";
    StringBuilder sb = new StringBuilder();
    for(int x = 0; x < s.length(); x++){
      char bats = s.charAt(x);
      if(Character.isLetter(bats)){
        int john = Character.toUpperCase(bats) - 'A' + 1;
        char hermano = Character.isUpperCase(bats) ? 'U' : 'L';
        sb.append(john).append(hermano);
      } else {
        sb.append(bats);
      }
      if(x != s.length() - 1) sb.append('-');
    }
    return build += sb;
  }
 
 
 // DECODING #1: Number to letter coding
String decryptLetternumber(String s){
   String build = "";
    StringBuilder sb = new StringBuilder();
    for(String p : s.split("-")){
        if(Character.isDigit(p.charAt(0))){
            int n = Integer.parseInt(p.replaceAll("[^0-9]", ""));
            char c = (char)('A' + n - 1);
            sb.append(p.contains("L") ? Character.toLowerCase(c) : c);
        } else sb.append(p);
    }
    return build += sb;
}


}