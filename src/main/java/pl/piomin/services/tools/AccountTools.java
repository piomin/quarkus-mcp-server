package pl.piomin.services.tools;

import io.quarkiverse.mcp.server.Tool;
import io.quarkiverse.mcp.server.ToolArg;
import jakarta.enterprise.context.ApplicationScoped;
import pl.piomin.services.domain.Accounts;
import pl.piomin.services.repository.AccountRepository;

@ApplicationScoped
public class AccountTools {

    AccountRepository accountRepository;

    public AccountTools(AccountRepository AccountRepository) {
        this.accountRepository = AccountRepository;
    }

    @Tool(description = "Find all Accounts by person ID")
    public Accounts getAccountsByPersonId(
            @ToolArg(name = "personId", description = "Person ID") Long personId) {
        return new Accounts(accountRepository.findByPersonId(personId));
    }

    @Tool(description = "Find all Accounts")
    public Accounts getAllAccounts() {
        return new Accounts(accountRepository.listAll());
    }

}
