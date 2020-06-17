package teste.classe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teste.base.BaseController;

@RestController
@RequestMapping("/api/classes")
public class ClasseController extends BaseController<Classe,ClasseRepository,ClasseService> {

}
