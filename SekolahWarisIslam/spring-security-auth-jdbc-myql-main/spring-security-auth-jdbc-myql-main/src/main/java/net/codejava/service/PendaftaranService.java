package net.codejava.service;

import net.codejava.models.Pendaftaran;
import net.codejava.repository.PendaftaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PendaftaranService {
    @Autowired
    private PendaftaranRepository pendaftaranRepository;

    public List<Pendaftaran> getAllPendaftaran() {
        return pendaftaranRepository.findAll();
    }

    public Pendaftaran getPendaftaranById(Long id) {
        return pendaftaranRepository.findById(id).orElse(null);
    }

    public Pendaftaran createPendaftaran(Pendaftaran pendaftaran) {
        return pendaftaranRepository.save(pendaftaran);
    }

    public Pendaftaran updatePendaftaran(Long id, Pendaftaran pendaftaranDetails) {
        Pendaftaran pendaftaran = pendaftaranRepository.findById(id).orElse(null);
        if (pendaftaran != null) {
            // Perbarui data pendaftaran dengan detail baru
            pendaftaran.setEmail(pendaftaranDetails.getEmail());
            pendaftaran.setNama(pendaftaranDetails.getNama());
            pendaftaran.setNoTelp(pendaftaranDetails.getNoTelp());
            // Pastikan id tidak berubah
            pendaftaran.setId(id);
            return pendaftaranRepository.save(pendaftaran);
        }
        return null;
    }

    public void deletePendaftaran(Long id) {
        pendaftaranRepository.deleteById(id);
    }
}
