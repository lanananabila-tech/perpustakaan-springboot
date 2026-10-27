package id.ac.ub.filkom.contoh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import id.ac.ub.filkom.contoh.entity.Anggota;
import id.ac.ub.filkom.contoh.repository.AnggotaRepository;

@Service
public class AnggotaService {

    private final AnggotaRepository anggotaRepository;

    public AnggotaService(AnggotaRepository anggotaRepository) {
        this.anggotaRepository = anggotaRepository;
    }

    public List<Anggota> semua() {
        return anggotaRepository.findAll();
    }

    public boolean tambah(String idAnggota, String nama, int batasPinjam) {
        String id = idAnggota.trim();
        if (anggotaRepository.existsById(id)) {
            return false;
        }
        anggotaRepository.save(new Anggota(id, nama.trim(), batasPinjam));
        return true;
    }
}