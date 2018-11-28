import { Component, OnInit } from '@angular/core';

import { NutrientService } from "../../services/nutrient/nutrient.service";
import { Nutrient } from "../../models/Nutrient";
import { Gym } from "../../models/Gym";
import {GymService} from "../../services/gym/gym.service";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  nutrition: Nutrient[] = [];
  gyms: Gym[] = [];

  constructor(private nutrientService: NutrientService,
              private gymService: GymService) { }

  ngOnInit() {
  }

  calculateNutrients(nutrient: string) {
    this.nutrientService.calculateNutrients(nutrient)
      .subscribe(nutrition => {
        this.nutrition = nutrition;
      });
  }

  findGyms(gym: string) {
    this.gymService.findGyms(gym)
      .subscribe(gyms => {
        this.gyms = gyms;
      });
  }

}
