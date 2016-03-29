package com.itwall.service;

import java.util.ArrayList;
import main.PersonaDTO;
/**
 * @author oscar lemoine
 */
public interface PersonaService{
    public PersonaDTO findById(PersonaDTO p);
    public ArrayList findAll();
//    public PersonaDTO deleteById(PersonaDTO p);
//    public PersonaDTO updateById(PersonaDTO p);
//    public PersonaDTO createPersona(PersonaDTO p);
}