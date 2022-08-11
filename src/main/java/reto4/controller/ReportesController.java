package reto4.controller;

import reto4.model.dao.ListaLideresDao;
import reto4.model.dao.DeudasPorProyectoDao;
import reto4.model.dao.ProyectosDao;
import reto4.model.vo.*;
import java.util.List;
import java.sql.SQLException;


public class ReportesController {
    private ProyectosDao proyectosDao;
    private DeudasPorProyectoDao deudasPorProyectoDao;
    private ListaLideresDao listaLiderasDao;

    public ReportesController(){
        proyectosDao = new ProyectosDao();
        deudasPorProyectoDao = new DeudasPorProyectoDao();
        listaLiderasDao = new ListaLideresDao();
    }
    public List<ProyectosVo> listarProyectos() throws SQLException{
        return proyectosDao.listar();
    }
    public List<DeudasPorProyectoVo> listarTotalAdeudadoProyectos() throws SQLException{
        return deudasPorProyectoDao.listar();
    }
    public List<ListaLideresVo> listarLideres() throws SQLException{
        return listaLiderasDao.listar();
    }
}
