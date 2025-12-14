package com.gabrielbirck.codinames.Repository;

import com.gabrielbirck.codinames.Class.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
