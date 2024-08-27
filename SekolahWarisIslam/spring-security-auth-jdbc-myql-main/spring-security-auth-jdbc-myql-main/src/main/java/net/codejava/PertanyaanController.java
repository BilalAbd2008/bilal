package net.codejava;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import net.codejava.repository.PertanyaanRepository;
import net.codejava.service.PertanyaanService;
import net.codejava.models.Pertanyaan;

@Controller
@RequestMapping("/pertanyaan")
public class PertanyaanController {

    @Autowired
    private PertanyaanRepository pertanyaanRepository;

    @Autowired
    private PertanyaanService pertanyaanService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("pertanyaan", new Pertanyaan());
        return "contact"; // ganti dengan nama file HTML tampilan Anda
    }
    

    @PostMapping("/save")
    public String createPertanyaan(Pertanyaan pertanyaan) {
        pertanyaanRepository.save(pertanyaan);
        return "redirect:/pertanyaan/form"; // ganti dengan halaman yang ingin Anda tampilkan setelah pengiriman berhasil
    }

    @RequestMapping("/delete/{id}")
    public String deletePertanyaan(@PathVariable("id") Long id) {
        pertanyaanService.deletePertanyaan(id);
        return "redirect:/pertanyaan/list";
    }

    @RequestMapping("/list")
    public String getAllPertanyaan(Model model) {
        List<Pertanyaan> daftarPertanyaan = pertanyaanService.getAllPertanyaan();
        model.addAttribute("daftarPertanyaan", daftarPertanyaan);
        return "daftarpertanyaan";
    }

}
