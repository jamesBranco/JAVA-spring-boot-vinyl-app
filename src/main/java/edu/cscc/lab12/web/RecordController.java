package edu.cscc.lab12.web;

import edu.cscc.lab12.model.RecordSize;
import edu.cscc.lab12.model.VinylRecord;
import edu.cscc.lab12.repo.VinylRecordRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecordController {

    @Autowired
    private VinylRecordRepository repo;

    @GetMapping("/")
    public String home() {
        return "redirect:/records";
    }

    @GetMapping("/records")
    public String records(Model model) {
        model.addAttribute("records", repo.findAll());
        return "records";
    }

    @GetMapping("/records/{id}")
    public String recordDetails(@PathVariable long id, Model model) {
        var recordOpt = repo.findById(id);
        if (recordOpt.isEmpty()) {
            return "error/404";
        }
        model.addAttribute("record", recordOpt.get());
        return "record-details";
    }

    @GetMapping("/add-record")
    public String addRecordForm(Model model) {
        model.addAttribute("record", new VinylRecord());
        model.addAttribute("sizes", RecordSize.values());

        long currentCount = repo.count();
        model.addAttribute("projectedCount", currentCount + 1); // EXTRA CREDIT
        return "add-record";
    }

    @PostMapping("/add-record")
    public String addRecordSubmit(
            @Valid @ModelAttribute("record") VinylRecord record,
            BindingResult bindingResult,
            Model model
    ) {
        // It will ALWAYS re-add these before returning add-record.html
        model.addAttribute("sizes", RecordSize.values());

        long currentCount = repo.count();
        model.addAttribute("projectedCount", currentCount + 1);

        // If validation fails, re-show the form WITH errors and required model attributes
        if (bindingResult.hasErrors()) {
            return "add-record";
        }

        VinylRecord saved = repo.save(record);
        return "redirect:/records/" + saved.getId();
    }
}
