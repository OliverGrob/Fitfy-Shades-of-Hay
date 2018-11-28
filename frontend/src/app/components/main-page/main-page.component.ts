import { Component, OnInit } from '@angular/core';

import { NutrientService } from "../../services/nutrient/nutrient.service";
import { Nutrient } from "../../models/Nutrient";
import { Gym } from "../../models/Gym";
import { GymService } from "../../services/gym/gym.service";
import {Workout} from "../../models/Workout";
import {WorkoutService} from "../../services/workout/workout.service";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  nutrition: Nutrient[] = [];
  gyms: Gym[] = [];
  workouts: Workout[] = [];

  constructor(private nutrientService: NutrientService,
              private gymService: GymService,
              private workoutService: WorkoutService) { }

  ngOnInit() {
  }

  calculateNutrients(nutrient: string, serving: string) {
    this.nutrientService.calculateNutrients(nutrient, serving)
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

  getWorkouts() {
    this.workoutService.getWorkout()
      .subscribe(workouts => {
        this.workouts = workouts;
      });
  }

}
