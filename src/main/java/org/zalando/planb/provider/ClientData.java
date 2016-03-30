package org.zalando.planb.provider;

import com.google.common.collect.ImmutableSet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.zalando.planb.provider.api.Client;

import java.util.Set;

@Getter
@AllArgsConstructor
@Builder
public class ClientData {

    private String clientSecretHash;
    private Set<String> scopes;
    private Boolean confidential;
    private String name;
    private String description;
    private Set<String> redirectUris;
    private String createdBy;
    private String lastModifiedBy;

    public static ClientData copyOf(Client client) {
        return ClientData.builderOf(client).build();
    }

    public static ClientDataBuilder builderOf(Client client) {
        return ClientData.builder()
                .clientSecretHash(client.getSecretHash())
                .scopes(ImmutableSet.copyOf(client.getScopes()))
                .confidential(client.getIsConfidential())
                .name(client.getName())
                .description(client.getDescription())
                .redirectUris(ImmutableSet.copyOf(client.getRedirectUris()));
    }


}
