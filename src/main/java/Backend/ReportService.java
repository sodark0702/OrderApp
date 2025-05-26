package Backend;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ReportService implements IReportService {
    private IOrderRepository orderRepo;

    public ReportService(IOrderRepository repo) {
        this.orderRepo = repo;
    }

    @Override
    public List<Order> getOrdersForToday() {
        return orderRepo.getAllOrder().stream()
                .filter(o -> o.getCreateDate().toLocalDate().equals(LocalDate.now()))
                .collect(Collectors.toList());
    }
}



