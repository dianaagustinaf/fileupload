package com.example.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.example.entities.Persona;
import com.example.services.PaisService;
import com.example.services.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class PersonaController {
    
    @Autowired
    private PersonaService personaService;

    @Autowired
    private PaisService paisService;


    @GetMapping("/base")
    public String base() {
        return "base";
    }


    @GetMapping("/listar")
    public String listar(Model model){

        model.addAttribute("personas", personaService.findAll());

        return "listar";
    }

    @GetMapping("/alta")
    public String alta(Model model) {
        
        model.addAttribute("persona", new Persona());
        model.addAttribute("paises", paisService.findAll());

        return "formAlta";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute(name = "persona") Persona persona, 
                        @RequestParam(name = "file") MultipartFile imagen) {
                    // requestParam toma del tag input la etiqueta NAME
        
        if (!imagen.isEmpty()){
            //Ruta Relativa a la carpeta static donde por defecto se almacenan los archivos
            Path imageFolder = Paths.get("src/main/resources/static/imagenes");

            //construir la ruta absoluta de raiz
            String rutaAbsoluta = imageFolder.toFile().getAbsolutePath();

            // convertir en un array de bytes
            // sirve para cualquier tipo de archivos 
            try {

                byte[] imagenBytes = imagen.getBytes(); // (imagen x param)

                // guardar este array en la ruta abs
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());

                Files.write(rutaCompleta, imagenBytes);

                // asignar al campo foto
                persona.setFoto(imagen.getOriginalFilename());

                //persistir el obj Persona en la bd
                personaService.save(persona);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return "redirect:/listar";
    }


    @GetMapping("/detalle/{id}")
    public String detalle(@PathVariable(name = "id") Long id, Model model) {
        
        Persona persona = personaService.findById(id);
        model.addAttribute("persona", persona);

        return "detalle";
    }



}
