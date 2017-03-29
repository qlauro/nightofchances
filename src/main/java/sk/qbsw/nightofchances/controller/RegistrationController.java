package sk.qbsw.nightofchances.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.qbsw.nightofchances.configuration.PathConfiguration;
import sk.qbsw.nightofchances.model.SyncCollection;
import sk.qbsw.nightofchances.model.domain.Registration;
import sk.qbsw.nightofchances.service.RegistrationService;

/**
 * The registration controller.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller (PathConfiguration.REGISTRATIONS_ROOT_PATH)
public class RegistrationController
{
	@Autowired
	private RegistrationService registrationService;

	@RequestMapping ()
	@ResponseBody
	public SyncCollection<Registration> getSyncData (@RequestParam (name = PathConfiguration.APPLICATION_ID_PARAM) Long applicationId)
	{
		return registrationService.getSyncData(applicationId);
	}
}
