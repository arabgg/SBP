import java.util.HashMap;
import java.util.Map;

public class No7 {
    private Map<String, Boolean> fakta;
    private Map<String, String[]> aturan;

    public No7() {
        // Inisialisasi fakta awal
        fakta = new HashMap<>();
        fakta.put("A", true);
        fakta.put("E", true);

        // Inisialisasi aturan
        aturan = new HashMap<>();
        aturan.put("R1", new String[]{"A", "B"});
        aturan.put("R2", new String[]{"C"});
        aturan.put("R3", new String[]{"A", "E"});
        aturan.put("R4", new String[]{"A", "H"});
        aturan.put("R5", new String[]{"F", "G"});
        aturan.put("R6", new String[]{"G", "E"});
        aturan.put("R7", new String[]{"C", "H"});
        aturan.put("R8", new String[]{"I", "A"});
        aturan.put("R9", new String[]{"G","J"});
        aturan.put("R10", new String[]{"J"});
        aturan.put("R11", new String[]{"K", "L"});
        aturan.put("R12", new String[]{"D", "F"});
        aturan.put("R13", new String[]{"F", "G", "J", "K"});
    }

    // Method untuk mengecek apakah sebuah aturan dapat dijalankan
    private boolean cekAturan(String[] antecedent) {
        for (String faktor : antecedent) {
            if (!fakta.containsKey(faktor) || !fakta.get(faktor)) {
                return false;
            }
        }
        return true;
    }

    // Method untuk mengecek semua aturan dan menerapkan yang sesuai
    public void forwardChaining() {
        boolean perubahan;

        do {
            perubahan = false;

            for (Map.Entry<String, String[]> entry : aturan.entrySet()) {
                String aturanKey = entry.getKey();
                String[] antecedent = entry.getValue();

                // Cek apakah aturan dapat dijalankan
                if (cekAturan(antecedent) && (!fakta.containsKey(aturanKey) || !fakta.get(aturanKey))) {
                    // Terapkan konsekuensi aturan
                    fakta.put(aturanKey, true);
                    perubahan = true;

                    // Menambahkan aturan baru jika K ditambahkan
                    if (aturanKey.equals("K")) {
                        aturan.put("R11", new String[]{"K", "L"});
                    }
                }
            }
        } while (perubahan);
    }

    // Method untuk mendapatkan fakta
    public Map<String, Boolean> getFakta() {
        return fakta;
    }

    // Method untuk menampilkan fakta awal
    public void tampilkanFaktaAwal() {
        System.out.println("Fakta awal :");
        for (Map.Entry<String, Boolean> entry : fakta.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Method untuk menampilkan fakta baru setelah forward chaining
    public void tampilkanFaktaAkhir() {
        System.out.println("Fakta akhir :");
        for (Map.Entry<String, Boolean> entry : fakta.entrySet()) {
            if (entry.getKey().equals("F") || entry.getKey().equals("G") || entry.getKey().equals("H") || entry.getKey().equals("J") || entry.getKey().equals("K") || entry.getKey().equals("D")) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}