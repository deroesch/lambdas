package org.deroesch.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.deroesch.lambdas.models.Customer;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */
@Slf4j
public class App {

    final Customer alice = new Customer("alice", "alice@example.com", "412-555-1111");
    final Customer bob = new Customer("bob", "bob@example.com", "412-555-2222");
    final Customer charlie = new Customer("charlie", "charlie@example.com", "412-555-3333");

    public void main(final String[] args) {
        log.info("Starting!");

        List<Customer> filtered = getCustomers().stream().filter(c -> c.getName().startsWith("a"))
                .collect(Collectors.toList());
        log.info(filtered.get(0).toString());

        List<String> strings = getCustomers().stream().map(Customer::getName).collect(Collectors.toList());
        log.info(strings.toString());
    }

    List<Customer> getCustomers() {
        return Arrays.asList(new Customer[] { new Customer(alice), new Customer(bob), new Customer(charlie) });
    }
}
