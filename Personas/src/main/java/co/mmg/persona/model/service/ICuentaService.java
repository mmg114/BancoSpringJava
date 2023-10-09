package co.mmg.persona.model.service;

import co.mmg.persona.model.entity.Cuenta;

import java.util.List;

public interface ICuentaService {

  Cuenta save(Cuenta cuenta) throws Exception;

  Cuenta update(Cuenta cuenta) throws Exception;

  void delete(String numeroDeCuenta) throws Exception;

  Cuenta findByNumberCount(String id) throws Exception;

  List<Cuenta> findByAll() throws Exception;
}
