class UseAudio2 {
  public static void main(String[] args) {
    Audio a = new Stereo();
    System.out.println("---Stereoを使う");
    a.play();
    a.stop();
    
    a = new MP#Player();
    System.out.println("---MP3Playerを使う---");
    a.play();
    a.stop();
  }
}
