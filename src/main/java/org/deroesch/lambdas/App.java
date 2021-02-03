package org.deroesch.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.deroesch.lambdas.models.TeamMember;

import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */
@Slf4j
public class App {

    final TeamMember alice = new TeamMember("alice", "alice@example.com", "412-555-1111");
    final TeamMember bob = new TeamMember("bob", "bob@example.com", "412-555-2222");
    final TeamMember charlie = new TeamMember("charlie", "charlie@example.com", "412-555-3333");

    public void main(final String[] args) {
        log.info("Starting!");

        List<TeamMember> filtered = getCustomers().stream().filter(c -> c.getName().startsWith("a"))
                .collect(Collectors.toList());
        log.info(filtered.get(0).toString());

        List<String> strings = getCustomers().stream().map(TeamMember::getName).collect(Collectors.toList());
        log.info(strings.toString());
    }

    List<TeamMember> getCustomers() {
        return Arrays.asList(new TeamMember[] { new TeamMember(alice), new TeamMember(bob), new TeamMember(charlie) });
    }
}
