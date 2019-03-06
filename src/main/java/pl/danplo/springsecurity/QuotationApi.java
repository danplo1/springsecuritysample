package pl.danplo.springsecurity;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController// klasa z usługami restowymi
public class QuotationApi {

    private List<Quotation> quotations;

    public QuotationApi() {
        this.quotations = new ArrayList<>();
        quotations.add(new Quotation("To, że milczę, nie znaczy, że nie mam nic do powiedzenia",
                "Jonathan Carroll"));
        quotations.add(new Quotation("Kto czyta książki, żyje podwójnie.", "Umberto Eco"));
        quotations.add(new Quotation("Śmierć jest łatwa, prosta, życie jest trudniejsze.", "Stephenie Meyer"));
        quotations.add(new Quotation("Nie składaj obietnic, jeśli nie jesteś pewny, czy zamierzasz ich dotrzymać.",
                "Nicholas Sparks"));
    }


    @GetMapping("/api") //pobieranie
    public List<Quotation> getQuotation() {
        return quotations;

    }

    @PostMapping("/api") //dodawanie
    public boolean addQuotation(@RequestBody Quotation quotation) {
        return quotations.add(quotation);

    }

    @DeleteMapping ("/api") //usuwanie
    public void deleteQuotation(@RequestParam int index) {
            quotations.remove(index);

    }

}
