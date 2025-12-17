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
    // Encoding the plaintext:
    String file = Input.readFile("Original.txt");
    // Encode level 1 (reverse)
    String encodedMsg1 = reverse(file);
    Input.writeFile("Encode1.txt", encodedMsg1);
    // // Encode level 2 (cipher )
    String encodedMsg2 = encodeC(encodedMsg1);
    Input.writeFile("Encode2.txt", encodedMsg2);
    // // Encode level 3 (letter to number)
    String encodedMsg3 = letternumber(encodedMsg2);
    Input.writeFile("Encode3.txt", encodedMsg3);

    
    // Decoding the ciphertext: 
    String file2 = Input.readFile("Encode3.txt");
    // Decode level 1  (number to letter)
    String decodedMsg1 = decryptLetternumber(file2);
    Input.writeFile("Decode1.txt", decodedMsg1);
    // Decode level 2 (cipher)
    String decodedMsg2 = decodeC(decodedMsg1);
    Input.writeFile("Decode2.txt", decodedMsg2);
    // Decode level 3 (reverse)
    String decodedMsg3 = reverse(decodedMsg2);
    Input.writeFile("Decode3.txt", decodedMsg3);

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
  
  
  // Encoding #2: Ciphering by 6
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

  // Decoding #2: Ciphering by 6
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
    StringBuilder supes = new StringBuilder();
    for(int x = 0; x < s.length(); x++){
      char bats = s.charAt(x);
      if(Character.isLetter(bats)){
        int john = Character.toUpperCase(bats) - 'A' + 1;
        char hermano = Character.isUpperCase(bats) ? 'U' : 'L';
        supes.append(john).append(hermano);
      } else {
        supes.append(bats);
      }
      if(x != s.length() - 1) 
        supes.append('-');
    }
    return build += supes;
  }
 
 
 // DECODING #1: Number to letter coding
String decryptLetternumber(String cheese){
   String build = "";
    StringBuilder wonder = new StringBuilder();
    for(String p : cheese.split("-")){
        if(Character.isDigit(p.charAt(0))){
            int eger = Integer.parseInt(p.replaceAll("[^0-9]", ""));
            char coal = (char)('A' + eger - 1);
            wonder.append(p.contains("L") ? Character.toLowerCase(coal) : coal);
        } else wonder.append(p);
    }
    return build += wonder;
}


}