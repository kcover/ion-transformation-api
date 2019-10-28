/**
 * Copyright (c) Connexta
 *
 * <p>This is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or any later version.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details. A copy of the GNU Lesser General Public
 * License is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 */
package com.connexta.transformation.rest.spring;

import com.connexta.transformation.rest.models.ErrorResponse;
import com.connexta.transformation.rest.models.MetadataType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Implementations of the {@code TransformApiRetrieve} interface provide a mechanism to implement
 * the rest GET/retrieve endpoint. This interface was manually separated out from the generated
 * TransformApi.java file and any changes must be updated here as well. This was done to allow the
 * creation of separate controller classes along with what gets changed/added. This interface
 * currently adds the throws Exception to the method signature.
 */
@Validated
@Api(value = "transform", description = "the transform API")
public interface TransformApiRetrieve {

  @ApiOperation(
      value = "Retrieve metadata.",
      nickname = "retrieve",
      notes = "Used to retrieve the metadata for a transform request.",
      response = Resource.class,
      tags = {
        "transform",
      })
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully retrieved.", response = Resource.class),
        @ApiResponse(
            code = 400,
            message =
                "The client message could not be understood by the server due to invalid format or syntax.",
            response = ErrorResponse.class),
        @ApiResponse(
            code = 401,
            message = "The client could not be authenticated.",
            response = ErrorResponse.class),
        @ApiResponse(
            code = 403,
            message = "The client is not authorized.",
            response = ErrorResponse.class),
        @ApiResponse(
            code = 404,
            message = "The transform request could not be found.",
            response = ErrorResponse.class),
        @ApiResponse(
            code = 501,
            message =
                "The requested API version is not supported and therefore not implemented. Possible codes reported are: - 501001 - Unable to parse *Accept-Version* - 501002 - The provided major version is no longer supported - 501003 - The provided major version is not yet supported by the server - 501004 - The provided minor version is not yet supported by the server ",
            response = ErrorResponse.class),
        @ApiResponse(
            code = 200,
            message = "Any other possible errors not currently known.",
            response = ErrorResponse.class)
      })
  @RequestMapping(
      value = "/transform/{TransformId}/{MetadataType}",
      produces = {"application/octet-stream", "application/json"},
      method = RequestMethod.GET)
  default ResponseEntity<Resource> retrieve(
      @ApiParam(value = "The ID of the transform request. ", required = true)
          @PathVariable("TransformId")
          String transformId,
      @ApiParam(value = "The metadata format ID.", required = true, allowableValues = "\"irm\"")
          @PathVariable("MetadataType")
          MetadataType metadataType)
      throws Exception {
    return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
  }
}
