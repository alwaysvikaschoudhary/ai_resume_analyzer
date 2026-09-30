package io.subbu.ai.firedrill.repos;

import io.subbu.ai.firedrill.entities.CompanyImpression;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository for global company impressions, keyed by normalised company name.
 */
public interface CompanyImpressionRepository extends JpaRepository<CompanyImpression, UUID> {

    /**
     * Find an existing impression for a company name (case-insensitive).
     */
    Optional<CompanyImpression> findByCompanyNameIgnoreCase(String companyName);

    /**
     * Bulk lookup used to assemble impression context for a candidate's employers.
     */
    List<CompanyImpression> findByCompanyNameInIgnoreCase(List<String> companyNames);
}
