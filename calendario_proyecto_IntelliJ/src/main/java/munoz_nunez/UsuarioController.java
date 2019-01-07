package munoz_nunez;

import munoz_nunez.Exceptions.CalendarioInexistente;
import munoz_nunez.Exceptions.CampoInvalido;
import munoz_nunez.Exceptions.EventoInexistente;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;
import java.util.*;


@RestController

@RequestMapping("/usuario")
public class UsuarioController {


    Usuario user= new Usuario();


    @RequestMapping("/calendario")
    public Calendario getCalendario(){
        return new Calendario("calendario1");
    }

    @RequestMapping("/string")
    public String getString(){
        return "cadena";
    }


    @RequestMapping(value = "/calendario/agregar", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public Calendario postCalendario(@RequestBody Calendario c){
        user.agregarCalendario(c);
        return c;
    }





    @RequestMapping(value="/calendarios/tomar/{idCalendario}", method = RequestMethod.GET)
    public Calendario getCalendario(@PathVariable("idCalendario") String id){
        Calendario c=null;
        try{
            c = user.getCalendarioPorNombre(id);
        }catch (CalendarioInexistente ci){
            ci.getMessage();
        }
        return c;
    }






    @RequestMapping(value="/calendarios/{idCalendario}/mostrarEventosPorDia", method = RequestMethod.GET)
    public HashSet<Evento> eventosPorDia(@RequestParam("{idCalendario}") String id, @RequestParam(value = "dia") int dia,
                                         @RequestParam(value = "mes") int mes,@RequestParam(value = "anio") int anio){
        Calendario c=null;
        try{
            c = user.getCalendarioPorNombre(id);
        }catch (CalendarioInexistente ci){
            ci.getMessage();
        }

        return c.eventosPorDia(new GregorianCalendar( anio,mes-1, dia));
    }




    @RequestMapping(value="/calendarios/{idCalendario}/mostrarEventosPorTresDias", method = RequestMethod.GET)
    public HashSet<Evento> eventosPorTresDias(@RequestParam("{idCalendario}") String id, @RequestParam(value = "dia") int dia,
                                         @RequestParam(value = "mes") int mes,@RequestParam(value = "anio") int anio){
        Calendario c=null;
        try{
            c = user.getCalendarioPorNombre(id);
        }catch (CalendarioInexistente ci){
            ci.getMessage();
        }

        return c.eventosPorTresDias(new GregorianCalendar( anio,mes-1, dia));
    }





    @RequestMapping(value="/calendarios/{idCalendario}/mostrarEventosPorSemana", method = RequestMethod.GET)
    public HashSet<Evento> eventosPorSemana(@RequestParam("{idCalendario}") String id, @RequestParam(value = "dia") int dia,
                                         @RequestParam(value = "mes") int mes,@RequestParam(value = "anio") int anio){
        Calendario c=null;
        try{
            c = user.getCalendarioPorNombre(id);
        }catch (CalendarioInexistente ci){
            ci.getMessage();
        }

        return c.eventosPorSemana(new GregorianCalendar( anio,mes-1, dia));
    }





    @RequestMapping(value="/calendarios/{idCalendario}/mostrarEventosPorMes", method = RequestMethod.GET)
    public HashSet<Evento> eventosPorMes(@RequestParam("{idCalendario}") String id, @RequestParam(value = "dia") int dia,
                                            @RequestParam(value = "mes") int mes,@RequestParam(value = "anio") int anio){
        Calendario c=null;
        try{
            c = user.getCalendarioPorNombre(id);
        }catch (CalendarioInexistente ci){
            ci.getMessage();
        }

        return c.eventosPorMes(new GregorianCalendar( anio,mes-1, dia));
    }




    @RequestMapping(value="/calendarios/agregar/{idCalendario}/", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public Evento postEvento(@RequestBody Evento e, @RequestParam("{idCalendario}") String id){
        Calendario c=null;
        try{
            c = user.getCalendarioPorNombre(id);
        }catch (CalendarioInexistente ci){
            ci.getMessage();
        }

        c.crearEvento(e);
        return e;
    }





    @RequestMapping(value ="/calendarios/{idCalendario}/{idEvento}/{campo}/", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Evento editarEvento(@RequestBody Object o, @RequestParam("idCalendario") String idCalendario,
                               @RequestParam("idEvento") String idEvento, @RequestParam("campo") int campo){

        Evento e=null;
        try{
            Calendario c = user.getCalendarioPorNombre(idCalendario);
            e=c.buscarEventoPorTitulo(idEvento);
            c.editarEvento(idEvento, campo, o);
        }catch(CalendarioInexistente ci){
            ci.printStackTrace();
        }catch(EventoInexistente ei){
            ei.printStackTrace();
        }catch(CampoInvalido cii){
            cii.printStackTrace();
        }

        return e;
    }




    @RequestMapping(value = "/calendarios/eliminar/{idCalendario}/{idEvento}", method = RequestMethod.DELETE)
    public void eliminarEvento(@RequestParam("idCalendario")String idCalendario, @RequestParam("idEvento") String idEvento){
        try{
            Calendario c=user.getCalendarioPorNombre(idCalendario);

            c.eliminarEvento(idEvento);
        }catch(CalendarioInexistente ci){
            ci.printStackTrace();
        }catch(EventoInexistente ei){
            ei.printStackTrace();
        }

    }




    @RequestMapping(value ="/vistaDeAgenda/{idCalendario}", method = RequestMethod.GET)
    public String vistaDeAgenda(@RequestParam("idCalendario") String idCalendario){
        Calendario c=null;
        try{
            c=user.getCalendarioPorNombre(idCalendario);

        }catch(CalendarioInexistente ci){
            ci.printStackTrace();
        }
        return user.vistaDeAgenda(c);
    }


}
