package com.kavanant.codesystem.medicines;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	MedicineRepository medicinerepository;

	@Override
	public Page<Medicine> getAllMedicineByPagination(Pageable pageable) {
		// TODO Auto-generated method stub
		return medicinerepository.findAll(pageable);
	}

	@Override
	public Page<Medicine> getNDCorName(String NDCorName, Pageable pageable) {
		// TODO Auto-generated method stub
		return medicinerepository.getNDCorName(NDCorName, pageable);
	}

	@Override
	public List<Medicine> getMedicines() {
		// TODO Auto-generated method stub
		return medicinerepository.findAllInActiveRecords();
	}

	public Medicine getMedicineByAiid(int aiid) {
		// TODO Auto-generated method stub
		return medicinerepository.findById(aiid).get();
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) {
		Optional<Medicine> existingmed = medicinerepository.findById(medicine.getAiid());

		existingmed.ifPresent(existingMed -> {
			// Updating Existing Code
			existingMed.setVersionState("InValid");
			// existingCptCode.setRetired("Y");
			medicinerepository.save(existingMed);

			// Inserting Modified Code As New One
			medicine.setRefId(existingMed.getAiid());
			medicine.setOriginalRefId(existingMed.getOriginalRefId());
			medicine.setVersionState("Validated");
			medicine.setAiid(0);
			medicinerepository.save(medicine);

		});

		return medicine;
	}

	
	@Override
	public Medicine addMedicine(Medicine medrequest) {
		// TODO Auto-generated method stub
		Optional<Medicine> existingMedicine = medicinerepository.getMedicineByCodeAndVersionState(medrequest.getAiid());

		if (existingMedicine.isPresent()) {
			return existingMedicine.get();
		} else {
			Medicine savedMed = medicinerepository.save(medrequest);
			savedMed.setRefId(savedMed.getAiid());
			savedMed.setOriginalRefId(savedMed.getAiid());

			return medicinerepository.save(savedMed);
		}
	}

}
