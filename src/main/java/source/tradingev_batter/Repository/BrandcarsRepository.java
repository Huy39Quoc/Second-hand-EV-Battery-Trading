package source.tradingev_batter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import source.tradingev_batter.Entity.Brandcars;

@Repository
public interface BrandcarsRepository  extends JpaRepository<Brandcars,Long> {
}
