class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

// Adrian and Asael's Encryption Methods

String originale = "Papoy is Cool";
String reversed = ;
  void init(){

    print("Original: " + originale);
    print("Reversed: " + reverse(originale));
    print("Encoded: " + encodeC(originale));
    print("Decoded: " + decode(encodeC(originale)));
    print("Letter to Number: " + letternumber(originale));
    print("Decrypted Letters: " + decryptLetternumber(letternumber(originale)));

  }
  int randomNum = (int)(Math.random() * 20) + 1; 
  
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
      ascii += randomNum;
      build += (char)ascii;
    }     
    return build;
  }

  // Decoding #2: Ciphering by random numbers
  String decode(String txt){
    String build="";
    int ascii;
    char ch='\0';
    for(int x=0; x<=txt.length()-1; x++){
      ch=txt.charAt(x);
      ascii = (int)ch;
      ascii -= randomNum;
        build += (char)ascii;
    }
    return build;
  }

  //  Encoding #3: Letter to number coding
  // Read the "Letter to number encryption explanation" google doc for the explanation of this function
  String letternumber(String s){
    StringBuilder sb = new StringBuilder();
    for(int x = 0; x < s.length(); x++){
      char bats = s.charAt(x);
      if(Character.isLetter(bats)){
        int num = Character.toUpperCase(bats) - 'A' + 1;
        sb.append(num);
      } else {
        sb.append(bats);
      }
      if(x != s.length() - 1) sb.append('-');
    }
    return sb.toString();
  }
 
 
 // DECODING #1: Number to letter coding
  // Stringbuilder is able to be changed more than just String.
  // Appending will add data to the end of it, which is a more efficient way of modifying strings.
  String decryptLetternumber(String s){
    StringBuilder sb = new StringBuilder();
    String[] parts = s.split("-");
    for(int i=0;i<parts.length;i++){
      String p = parts[i];
      boolean Booster = p.length() > 0;
      for(int j=0;j<p.length() && Booster;j++) if(!Character.isDigit(p.charAt(j))) Booster = false;
      if(Booster){
        int n = Integer.parseInt(p);
        sb.append((char)('A' + n - 1));
      } else sb.append(p);
    }
    return sb.toString();
  }




}
