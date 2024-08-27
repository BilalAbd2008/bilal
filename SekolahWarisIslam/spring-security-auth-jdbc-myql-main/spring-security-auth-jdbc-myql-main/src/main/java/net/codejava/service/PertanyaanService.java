package net.codejava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import net.codejava.repository.PertanyaanRepository;
import net.codejava.models.Pendaftaran;
import net.codejava.models.Pertanyaan;

@Service
public class PertanyaanService {

    @Autowired
    private PertanyaanRepository pertanyaanRepository;

    public List<Pertanyaan> getAllPertanyaan() {
        return pertanyaanRepository.findAll();
    }

    public Pertanyaan getPertanyaanById(Long id) {
        return pertanyaanRepository.findById(id).orElse(null);
    }

    public Pendaftaran createPendaftaran(Pendaftaran pendaftaran) {
        return pertanyaanRepository.save(pendaftaran);
    }

    public Pertanyaan simpanPertanyaan(Pertanyaan pertanyaan) {
        return pertanyaanRepository.save(pertanyaan);
    }

    public void deletePertanyaan(Long id) {
        pertanyaanRepository.deleteById(id);
    }

    public Pertanyaan updatePertanyaan(Long id, Pertanyaan pertanyaanDetails) {
        Pertanyaan Pertanyaan = pertanyaanRepository.findById(id).orElse(null);
        if (Pertanyaan != null) {
            Pertanyaan.setNama(pertanyaanDetails.getNama());
            Pertanyaan.setEmail(pertanyaanDetails.getEmail());
            Pertanyaan.setJudul(pertanyaanDetails.getJudul());
            Pertanyaan.setIsi(pertanyaanDetails.getIsi());
            Pertanyaan.setId(id);
            return pertanyaanRepository.save(Pertanyaan);
        }
        return null;
    }
}
