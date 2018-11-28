import { Component, OnInit } from '@angular/core';

import { NutrientService } from "../../services/nutrient/nutrient.service";
import { Nutrient } from "../../models/Nutrient";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  nutrition: Nutrient[] = [];

  constructor(private nutrientService: NutrientService) { }

  ngOnInit() {
  }

  calculateNutrients(nutrient: string) {
    this.nutrientService.calculateNutrients(nutrient)
      .subscribe(nutrition => {
        this.nutrition = nutrition;
      });
  }

}
