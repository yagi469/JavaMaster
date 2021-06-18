class Stereo implements Audio {
  public void play() {
    System.out.println("ステレオを再生します。");
  }
  public void stop() {
    System.out.println("ステレオを停止します。");
  }
}

class MP3Player implements Audio {
  public void play() {
    System.out.println("MP3を再生します。");
  }
  public void stop() {
    System.out.println("MP3を停止します。");
  }
}

class UseAudio {
  public static void main(String[] args) {
    Stereo s = new Stereo();
    System.out.println("---Stereoを使う---");
    s.play();
    s.stop();
    
    MP3Player m = new MP3Player();
    System.out.println("---MP3Playerを使う---");
    m.play();
    m.stop();
  }
}
