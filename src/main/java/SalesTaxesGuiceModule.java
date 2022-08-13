import com.google.inject.AbstractModule;
import repository.StoreRepository;
import service.BillingService;
import service.ProductInputService;
import service.ProductService;

public class SalesTaxesGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ProductInputService.class);
        bind(ProductService.class);
        bind(StoreRepository.class);

        bind(BillingService.class);

    }
}
