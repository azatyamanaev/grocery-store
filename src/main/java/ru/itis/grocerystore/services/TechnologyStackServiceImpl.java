package ru.itis.grocerystore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.grocerystore.models.TechnologyStack;
import ru.itis.grocerystore.repositories.TechnologyStackRepository;

import java.util.List;

@Service
public class TechnologyStackServiceImpl implements TechnologyStackService {

    @Autowired
    private TechnologyStackRepository technologyStackRepository;

    @Override
    public List<TechnologyStack> getAll() {
        return technologyStackRepository.findAll();
    }
}
