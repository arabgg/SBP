public class MainNo7 {

    public static void main(String[] args) {
        No7 sistemPakar = new No7();
        sistemPakar.tampilkanFaktaAwal();

        // Menjalankan forward chaining
        sistemPakar.forwardChaining();

        // Menampilkan fakta akhir
        sistemPakar.tampilkanFaktaAkhir();

        // Menampilkan nilai K
        System.out.println("Nilai K: " + (sistemPakar.getFakta().containsKey("K") ? sistemPakar.getFakta().get("k") : true));
    }
}