/*
 * Copyright (c) 2020-2024 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.api.client.infrastructure

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import io.airbyte.config.FailureReason.FailureOrigin

/**
 * Custom Moshi adapter that handles the use of [FailureOrigin]
 * that is generated by the airbyte-config/config-models module.
 * <p />
 * This adapter ensures that the enumeration value serialized or
 * deserialized by Moshi can be converted to the config model representation.
 * This custom adapter is necessary because the config model defines the
 * enumerated values in lowercase, whereas Moshi by default will serialize
 * the enumerated value by its name, which is in uppercase.
 */
class FailureOriginAdapter {
  @ToJson
  fun toJson(value: FailureOrigin): String {
    return value.value()
  }

  @FromJson
  fun fromJson(value: String): FailureOrigin {
    return FailureOrigin.fromValue(value)
  }
}
