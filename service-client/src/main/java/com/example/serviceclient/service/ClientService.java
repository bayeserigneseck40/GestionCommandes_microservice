package com.example.serviceclient.service;

import com.example.serviceclient.exception.ClientInconnuExecption;
import com.example.serviceclient.exception.InvalideClientException;
import com.example.serviceclient.model.Client;
import com.example.serviceclient.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    /**
     * Ajout d'un client
     * @param clientt client à ajouter
     * @throws InvalideClientException
     */
    public void ajouterNouveauClient(Client client) throws InvalideClientException {
 
            clientRepository.save(client);
    }
    /**
     * Modification d'un client
     * @param client client à modifier
     */
    public void updateClient(Client client) throws ClientInconnuExecption {
        if (!clientRepository.existsById(client.getId())) {
            throw new ClientInconnuExecption("Cet client n'existe pas dans la base de données");
        }
        clientRepository.save(client);
    }
    /**
     * Suppression d'un client par son identifiant 
     * @param id id client
     * @throws clientInconnuExecption
     */
    public void supprimerClient(Long id) throws ClientInconnuExecption {
        if (!clientRepository.existsById(id)) {
            throw new ClientInconnuExecption("Cet client n'existe pas dans la base de données");
        }
        clientRepository.deleteById(id);
    }

    /**
     * recupération des clients enregistrés dans la bdd
     * @return liste client enregistrés
     */
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    /**
     * Recuperation d'un client par son ID 
     * @return client si trouvé, sinon null
     */
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }
    /**
     * Validation d'un client en verifiant si le numero  est déjà enregistré pour un autre étudiant
     * @param client
     * @return boolean booleen permettant de savoir ou pas si l'objet client reçu est valide.
     */
 
}
