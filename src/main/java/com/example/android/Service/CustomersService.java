    package com.example.android.Service;

    import com.example.android.Dto.CustomersDto;
    import com.example.android.Dto.ProductsDto;
    import com.example.android.Dto.SuppliersDto;
    import com.example.android.Entity.Customers;
    import com.example.android.Entity.Suppliers;
    import com.example.android.Repository.CustomersRepository;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.stream.Collectors;

    @Service
    public class CustomersService implements ICustomersService {

        private final CustomersRepository repository;



        public CustomersService(CustomersRepository repository) {
            this.repository = repository;
        }



        @Override
        public List<CustomersDto> getAll() {

            List<Customers> customersList = repository.findAll();
            return customersList.stream().map( c -> {
                CustomersDto dto = new CustomersDto();
                dto.setId(c.getId());
                dto.setName(c.getName());
                dto.setType(c.getType());
                dto.setPhone(c.getPhone());
                dto.setEmail(c.getEmail());


                return dto;
            }).toList();

        }

        public void save(CustomersDto dto) {
            Customers c = new Customers();

            c.setName(dto.getName());
            c.setType(dto.getType());
            c.setEmail(dto.getEmail());
            c.setPhone(dto.getPhone());


            repository.save(c);
        }
    }
