package br.com.dextra.scoremodels.event.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.dextra.scoremodels.entity.PerguntasClima;

@Service
public class PerguntasClimaService {

    public List<PerguntasClima> getPerguntas() {

        List<PerguntasClima> perguntas = new ArrayList<>();
        perguntas.add(new PerguntasClima(UUID.randomUUID().toString(), "Você conhece quais são as oportunidades de crescimento dentro da empresa?"));
        perguntas.add(new PerguntasClima(UUID.randomUUID().toString(), "A squad tem metas alinhadas aos objetivos?"));

        return perguntas;
    }

}
