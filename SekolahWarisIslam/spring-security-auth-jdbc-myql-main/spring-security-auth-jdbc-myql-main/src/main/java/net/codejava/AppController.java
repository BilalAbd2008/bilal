package net.codejava;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.codejava.models.Pendaftaran;
import net.codejava.service.PendaftaranService;
import net.codejava.models.Pertanyaan;
import net.codejava.repository.PendaftaranRepository;

@Controller
public class AppController {
	@Autowired
    private PendaftaranService pendaftaranService;
    private CrudRepository<Pendaftaran, Long> pendaftaranRepository;

    @RequestMapping("/")
    public String getAllPendaftaran(Model model) {
        List<Pendaftaran> daftarPendaftaran = pendaftaranService.getAllPendaftaran();
        model.addAttribute("daftarPendaftaran", daftarPendaftaran);
        return "index";
    }
	@RequestMapping("/indexx")
    public String showForm(Model model) {
        model.addAttribute("pendaftaranBaru", new Pendaftaran()); // Menambahkan objek Pendaftaran baru ke model
        return "indexx"; // Mengarahkan ke halaman index.html
    }

    @RequestMapping("/about")
    public String showAboutPage() {
        return "about"; // Pastikan ada file about.html di folder templates
    }

   @GetMapping("/contact")
    public String showContactForm(Model model) {
    model.addAttribute("pertanyaan", new Pertanyaan());
    return "contact";
}

    @RequestMapping("/daftar")
    public String showDaftarPage(Model model) {
        model.addAttribute("pendaftaranBaru", new Pendaftaran());
        return "daftar"; // Pastikan ada file daftar.html di folder templates
    }

    @RequestMapping("/blog")
    public String showBlogPage() {
        return "blog"; // Pastikan ada file blog.html di folder templates
    }

    @PostMapping("/index/save")
    public String savePendaftaran(@ModelAttribute("pendaftaranBaru") Pendaftaran pendaftaranBaru) {
        pendaftaranService.createPendaftaran(pendaftaranBaru);
        return "redirect:/indexx"; // Mengarahkan kembali ke halaman utama setelah pendaftaran disimpan
    }

    @RequestMapping("/formpendaftaran")
    public String showFormPendaftaran(Model model) {
        model.addAttribute("pendaftaranBaru", new Pendaftaran());
        return "formpendaftaran"; // Pastikan ada file formpendaftaran.html di folder templates
    }

	@RequestMapping("/edit/{id}")
    public String editPendaftaran(@PathVariable("id") Long id, Model model) {
        Pendaftaran pendaftaran = pendaftaranService.getPendaftaranById(id);
        model.addAttribute("pendaftaran", pendaftaran);
        return "edit_pendaftaran";
    }

    @PostMapping("/edit/{id}/update")
    public String updatePendaftaran(@PathVariable("id") Long id, @ModelAttribute("pendaftaran") Pendaftaran pendaftaranDetails) {
        pendaftaranService.updatePendaftaran(id, pendaftaranDetails);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deletePendaftaran(@PathVariable("id") Long id) {
        pendaftaranService.deletePendaftaran(id);
        return "redirect:/";
    }

    

    @RequestMapping("/post")
    public String post(){
        return "post";
    }
    @RequestMapping("/blogpembagianharta")
    public String blogpembagianharta(){
        return "blogpembagianharta";
    }

    @RequestMapping("/blogzakat")
    public String blogzakat(){
        return "blogzakat";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/daftarpertanyaan")
    public String daftarpertanyaan(){
        return "daftarpertanyaan";
    }
    @GetMapping("/findOne/{id}")
    public ResponseEntity<Pendaftaran> findOne(@PathVariable Long id) {
        Optional<Pendaftaran> pendaftaran = pendaftaranRepository.findById(id);
        if (pendaftaran.isPresent()) {
            return ResponseEntity.ok(pendaftaran.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<Pendaftaran> daftarPendaftaran = pendaftaranService.getAllPendaftaran();
        model.addAttribute("daftarPendaftaran", daftarPendaftaran);
        return "index"; // Sesuaikan dengan nama file HTML Anda
    }
}



