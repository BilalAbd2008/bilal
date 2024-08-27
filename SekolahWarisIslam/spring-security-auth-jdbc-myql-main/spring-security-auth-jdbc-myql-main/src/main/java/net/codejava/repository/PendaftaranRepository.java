package net.codejava.repository;

import net.codejava.models.Pendaftaran;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PendaftaranRepository extends JpaRepository<Pendaftaran, Long> {

    static Pendaftaran findOne(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }
}
