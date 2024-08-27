package net.codejava.repository;
import net.codejava.models.Pendaftaran;
import net.codejava.models.Pertanyaan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PertanyaanRepository extends JpaRepository<Pertanyaan, Long> {

    Pendaftaran save(Pendaftaran pendaftaran);
    // Tambahkan method tambahan jika diperlukan
}
