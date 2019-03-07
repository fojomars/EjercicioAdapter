package adaptadores;

public class Adaptadores {

    public static void main(String[] args) {
        MediaPlayer player = new MP3();
        player.play("file.mp3");
        player = new FormatAdapter(new MP4());
        player.play("file.mp4");
        player = new FormatAdapter(new VLC());
        player.play("file.avi");
        player = new FormatAdapter(new DivX());
        player.play("DivX.avi");
    }

    private static class FormatAdapter implements MediaPlayer {

        private MediaPackage media;
        private MediaDivX adapter2;

        public FormatAdapter(MediaPackage m) {
            media = m;
        }
        
        public FormatAdapter(MediaDivX a) {
            adapter2 = a;
        }        

        @Override
        public void play(String filename) {
            System.out.print("Using Adapter --> ");
            media.playFile(filename);
            adapter2.playFilm(filename);
            
        }
    }
}
